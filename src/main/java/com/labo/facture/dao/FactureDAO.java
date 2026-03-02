package com.labo.facture.dao;

import java.sql.*;
import java.util.*;
import com.labo.db.BDContext;

import com.labo.facture.beans.FactureBean;

public class FactureDAO {

    public void ajouterFacture(FactureBean f) throws Exception {

        Connection con = BDContext.getConnection();

        String sql = "INSERT INTO facture VALUES(?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, f.getId_facture());
        ps.setString(2, f.getNumero_facture());
        ps.setInt(3, f.getId_patient());
        ps.setDate(4, f.getDate_emission());
        ps.setDouble(5, f.getMontant_total());
        ps.setString(6, f.getStatus_paiement());
        ps.setDate(7, f.getDate_paiement());
        ps.setString(8, f.getMode_paiment());
        ps.setString(9, f.getObservation());

        ps.executeUpdate();
        con.close();
    }

    public List<FactureBean> getAllFactures() throws Exception {

        List<FactureBean> list = new ArrayList<>();

        Connection con = BDContext.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM facture");

        while (rs.next()) {
            FactureBean f = new FactureBean(
                rs.getInt("id_facture"),
                rs.getString("numero_facture"),
                rs.getInt("id_patient"),
                rs.getDate("date_emission"),
                rs.getDouble("montant_total"),
                rs.getString("status_paiement"),
                rs.getDate("date_paiement"),
                rs.getString("mode_paiment"),
                rs.getString("observation")
            );
            list.add(f);
        }

        con.close();
        return list;
    }

    public FactureBean getFactureById(int id) throws Exception {

        Connection con = BDContext.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM facture WHERE id_facture=?"
        );
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        FactureBean f = null;

        if (rs.next()) {
            f = new FactureBean(
                rs.getInt("id_facture"),
                rs.getString("numero_facture"),
                rs.getInt("id_patient"),
                rs.getDate("date_emission"),
                rs.getDouble("montant_total"),
                rs.getString("status_paiement"),
                rs.getDate("date_paiement"),
                rs.getString("mode_paiment"),
                rs.getString("observation")
            );
        }

        con.close();
        return f;
    }

    public void updateFacture(FactureBean f) throws Exception {

        Connection con = BDContext.getConnection();

        String sql = "UPDATE facture SET numero_facture=?, id_patient=?, " +
                     "montant_total=?, status_paiement=?, date_paiement=?, " +
                     "mode_paiment=?, observation=? WHERE id_facture=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, f.getNumero_facture());
        ps.setInt(2, f.getId_patient());
        ps.setDouble(3, f.getMontant_total());
        ps.setString(4, f.getStatus_paiement());
        ps.setDate(5, f.getDate_paiement());
        ps.setString(6, f.getMode_paiment());
        ps.setString(7, f.getObservation());
        ps.setInt(8, f.getId_facture());

        ps.executeUpdate();
        con.close();
    }

    public void deleteFacture(int id) throws Exception {

        Connection con = BDContext.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM facture WHERE id_facture=?"
        );
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }
}