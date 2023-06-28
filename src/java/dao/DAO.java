/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account login(String username, String password) {
        String query = "select a.*,ia.isSeller,ia.isAdmin from ducnthe140281_Account a\n"
                + "join ducnthe140281_Infor_Account ia\n"
                + "on a.accID = ia.infor_ID\n"
                + "where a.username = ?\n"
                + "and a.[password] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account checkAccount(String username) {
        String query = "select a.*,ia.isSeller,ia.isAdmin from ducnthe140281_Account a\n"
                + "join ducnthe140281_Infor_Account ia\n"
                + "on a.accID = ia.infor_ID\n"
                + "where a.username = ?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void signUp(String user, String pass) {
        String query = "insert into ducnthe140281_Account\n"
                + "values(?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void signUpInfor(String name, String gender, String email, String address, String phone, int seller, int admin) {
        String query = "insert into ducnthe140281_Infor_Account\n"
                + "values(?,?,?,?,?,0,0)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public List<Dog> getAllDog() {
        List<Dog> list = new ArrayList<>();
        String query = "select * from ducnthe140281_Dog";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Dog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from ducnthe140281_Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Dog> getProductByCategory(String cid) {
        List<Dog> list = new ArrayList<>();
        String query = "select * from ducnthe140281_Dog\n"
                + "where cateID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
               list.add(new Dog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Dog> getNext3Dog(int index) {
        List<Dog> list = new ArrayList<>();
        String query = "SELECT * FROM ducnthe140281_Dog\n"
                + "ORDER BY did\n"
                + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, index);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Dog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Dog> searchByName(String txt) {
        List<Dog> list = new ArrayList<>();
        String query = "select * from ducnthe140281_Dog\n"
                + "where [name] like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Dog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Dog> getTop3() {
        List<Dog> list = new ArrayList<>();
        String query = "select top 3 * from ducnthe140281_Dog";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Dog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Dog> get3Dogdesc() {
        List<Dog> list = new ArrayList<>();
        String query = "select * from ducnthe140281_Dog\n"
                + "order by price desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Dog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Dog> get3Dogasc() {
        List<Dog> list = new ArrayList<>();
        String query = "select * from ducnthe140281_Dog\n"
                + "order by price asc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Dog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Dog getDogByID(String id) {
        String query = "select * from ducnthe140281_Dog\n"
                + "where did = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Dog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public List<Dog> getDogBySellID(int id) {
        List<Dog> list = new ArrayList<>();
        String query = "select * from ducnthe140281_Dog\n"
                + "where sell_ID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Dog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteDog(String did) {
        String query = "delete from ducnthe140281_Dog\n"
                + "where did = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, did);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertDog(String name, String image, String price,
            String title, String description, String alimentation, String category, int sellId) {
        String query = "INSERT [dbo].[ducnthe140281_Dog]([name], [image],"
                + " [price], [title], [description], [alimentation], "
                + "[cateID], [sell_ID]) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, alimentation);
            ps.setString(7, category);
            ps.setInt(8, sellId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editDog(String name, String image, String price,
            String title, String description, String alimentation, String category, String pid) {
        String query = "update ducnthe140281_Dog\n"
                + "set [name] = ?,\n"
                + "[image] = ?,\n"
                + "price = ?,\n"
                + "title = ?,\n"
                + "[description] = ?,\n"
                + "[alimentation] = ?,\n"
                + "cateID = ?\n"
                + "where did = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, alimentation);
            ps.setString(7, category);
            ps.setString(8, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editInforAcc(String name, String gender, String email, String address,
            String phone, int aid) {
        String query = "update ducnthe140281_Infor_Account\n"
                + "set [name] = ?,\n"
                + "[gender] = ?,\n"
                + "[email] = ?,\n"
                + "[address] = ?,\n"
                + "[phoneNumber] = ?\n"
                + "where infor_ID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.setInt(6, aid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public AccountInformation getInforAccByID(int inforId) {
        String query = "select ia.* from ducnthe140281_Account a\n"
                + "join ducnthe140281_Infor_Account ia\n"
                + "on a.accID = ia.infor_ID\n"
                + "where ia.infor_ID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, inforId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new AccountInformation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void changePassword(String password, int accId) {
        String query = "update ducnthe140281_Account\n"
                + "set [password] = ?\n"
                + "where [accID] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, password);
            ps.setInt(2, accId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertDogToCart(int id, String name, String image,
            String title, String price, int amount) {
        String query = "INSERT [dbo].[ducnthe140281_CART]\n"
                + "           ([CartID],\n"
                + "		   [name],\n"
                + "		   [image]\n"
                + "           ,[title]\n"
                + "           ,[price]\n"
                + "           ,[amount])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)\n"
                + "\n"
                + "";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, image);
            ps.setString(4, title);
            ps.setString(5, price);
            ps.setInt(6, amount);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Cart> getAllDogToCart() {
        List<Cart> list = new ArrayList<>();
        String query = "select * from ducnthe140281_CART";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Cart(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteCartDog(String did) {
        String query = "delete from ducnthe140281_CART\n"
                + "where CartID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, did);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Total> totalCart() {
        String query = "select sum([price]*[amount]) from ducnthe140281_CART";
        List<Total> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Total(rs.getInt(1)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<managerAccount> getAllManagerAccount() {
        String query = "select a.*,ia.[name],ia.[email], ia.[address],ia.phoneNumber from ducnthe140281_Account a\n"
                + "join ducnthe140281_Infor_Account ia\n"
                + "on a.accID = ia.infor_ID";
        List<managerAccount> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new managerAccount(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public managerAccount getManagerInforAccByID(int accID) {
        String query = "select a.*,ia.[name],ia.[email], ia.[address],ia.phoneNumber from ducnthe140281_Account a\n"
                + "join ducnthe140281_Infor_Account ia\n"
                + "on a.accID = ia.infor_ID\n"
                + "where accID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, accID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new managerAccount(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
        }

        return null;
    }

    public void deleteAllCartDog() {
        String query = "delete from ducnthe140281_CART ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}

