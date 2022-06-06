package DAL;

import DTO.AccountsDTO;

import java.sql.*;
import java.util.ArrayList;

public class AccountsDAL {
    public ArrayList<AccountsDTO> getData() throws Exception {
        String sql = "Select * from tblaccounts";
        try (
            Connection conn = new DatabaseAccess().getConn();
            Statement stm = conn.createStatement()
        ) {
            try (ResultSet rs = stm.executeQuery(sql)) {
                ArrayList<AccountsDTO> listAccount = new ArrayList<>();
                while (rs.next()) {
                    AccountsDTO accountsDTO = new AccountsDTO();

                    accountsDTO.set__username(rs.getString("msUsername"));
                    accountsDTO.set__password(rs.getString("msPassword"));
                    listAccount.add(accountsDTO);
                }
                return listAccount;
            }
        }
    }
}
