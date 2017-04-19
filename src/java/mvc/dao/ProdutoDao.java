/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.sql.DataSource;
import mvc.bean.Administrador;
import mvc.bean.Categoria;
import mvc.bean.Cliente;
import mvc.bean.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author GRS
 */
@Repository
public class ProdutoDao {

    private final Connection connection;

    @Autowired
    public ProdutoDao(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    public void adciocnarProduto(Produto produto) {

        String sql = " insert into produto "
                + "(prodescricao,proquantde,provalor,proadminid,procatid,proimagem)"
                + " values(?,?,?,?,?,?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {

            if (produto.getProdescricao() != null) {
                stm.setString(1, produto.getProdescricao());
            } else {
                stm.setNull(1, java.sql.Types.VARCHAR);
            }

            if (produto.getProquantde() != 0) {
                stm.setInt(2, produto.getProquantde());
            } else {
                stm.setNull(2, java.sql.Types.INTEGER);
            }
            if (produto.getProvalor() != null) {
                stm.setDouble(3, produto.getProvalor());
            } else {
                stm.setNull(3, java.sql.Types.DOUBLE);
            }

            if (produto.getProcatid() != null) {
                stm.setDouble(4, produto.getProcatid());
            } else {
                stm.setNull(4, java.sql.Types.INTEGER);
            }

            if (produto.getProadminid() != null) {
                stm.setDouble(5, produto.getProadminid());
            } else {
                stm.setNull(5, java.sql.Types.INTEGER);
            }
            if (produto.getProimagem() != null) {
                stm.setString(6, produto.getProimagem());
            } else {
                stm.setNull(6, java.sql.Types.VARCHAR);
            }
            stm.execute();

        } catch (SQLException e) {
            System.out.println("Erro aqui dao Produto" + e.getMessage());
        }

    }

    public List<Produto> listarProdutos() {
        List<Produto> listaProdutos = new ArrayList<>();
        String sql = "select *from produto p "
                + " left outer join administrador a on p.proadminid= a.admid  "
                + " left outer join categoria c on p.procatid = c.cat_id "
                + " order by proid";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setProid(rs.getLong("proid"));
                produto.setProdescricao(rs.getString("prodescricao"));
                produto.setProquantde(rs.getInt("proqtde"));
                produto.setProvalor(rs.getDouble("provalor"));
                //produto.setProcatid( new Categoria(rs.getLong("procatid"),rs.getString("cat_descricao")));
                //produto.setProadminid(new Administrador(rs.getLong("proadminid"),rs.getString("adm_nome")));
                produto.setProcatid(rs.getLong("procatid"));
                produto.setProadminid(rs.getLong("proadminid"));
                produto.setProimagem(rs.getString("proimagem"));

                listaProdutos.add(produto);
            }
            return listaProdutos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Produto buscarProdutoPorId(Long id) {
        String sql = "select * "
                + " from produto "
                + " where proid=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            Produto produto = new Produto();
            if (rs.next()) {
                produto.setProid(rs.getLong("proid"));
                produto.setProdescricao(rs.getString("prodescricao"));
                produto.setProquantde(rs.getInt("proquantde"));
                produto.setProvalor(rs.getDouble("provalor"));
                //produto.setProcatid( new Categoria(rs.getLong("procatid"),rs.getString("cat_descricao")));
                //produto.setProadminid(new Administrador(rs.getLong("proadminid"),rs.getString("adm_nome")));
                produto.setProcatid(rs.getLong("procatid"));
                produto.setProadminid(rs.getLong("proadminid"));

                produto.setProimagem(rs.getString("proimagem"));
            }
            return produto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removerTarefa(Long id) {
        String sql = "delete from produto where proid = ? ";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean alterar(Produto produto) {
        String sql = "update produto set prodescricao=?, proquantde=? , provalor=? , procatid=?, proadminid=?,proimagem=?  where proid=?";
        try (
                PreparedStatement stm = connection.prepareStatement(sql)) {

            if (produto.getProdescricao() != null) {
                stm.setString(1, produto.getProdescricao());
            } else {
                stm.setNull(1, java.sql.Types.VARCHAR);
            }

            if (produto.getProquantde() != 0) {
                stm.setInt(2, produto.getProquantde());
            } else {
                stm.setNull(2, java.sql.Types.INTEGER);
            }
            if (produto.getProvalor() != null) {
                stm.setDouble(3, produto.getProvalor());
            } else {
                stm.setNull(3, java.sql.Types.DOUBLE);
            }

            if (produto.getProcatid() != null) {
                stm.setDouble(4, produto.getProcatid());
            } else {
                stm.setNull(4, java.sql.Types.INTEGER);
            }

            if (produto.getProadminid() != null) {
                stm.setDouble(5, produto.getProadminid());
            } else {
                stm.setNull(5, java.sql.Types.INTEGER);
            }
            if (produto.getProimagem() != null) {
                stm.setString(6, produto.getProimagem());
            } else {
                stm.setNull(6, java.sql.Types.VARCHAR);
            }
            // atributo que define o qual vai ser mudado
            stm.setLong(7, produto.getProid());

            stm.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
