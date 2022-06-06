package BLL;

import DAL.AccountsDAL;
import DTO.AccountsDTO;

import java.util.ArrayList;

public class AccountsBUS {

    private String __username;
    private String __password;

    public AccountsBUS(String username, String password) {
        this.__username = username;
        this.__password = password;
    }

    public boolean checkLogin() {
        try {
            ArrayList<AccountsDTO> listAccount = new AccountsDAL().getData();
            for (AccountsDTO accountsDTO: listAccount) {
                if (accountsDTO.get__username().equals(this.__username)
                    && accountsDTO.get__password().equals(this.__password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}