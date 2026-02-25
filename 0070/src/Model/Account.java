package Model;

public class Account {

    private String account, password;

    public Account() {
    }

    public Account(String account, String password) {
        setAccount(account);
        setPassword(password);
    }

    //GETTER
    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    //SETTER
    public final void setAccount(String account) {
        if (account.isEmpty() || account.matches(Utility.InputValidation.REGEX_ACCOUNT)) {
            throw new IllegalArgumentException("Invalid, account cannot empty");
        }
        this.account = account;
    }

    public final void setPassword(String password) {
        if (password.isEmpty() || password.matches(Utility.InputValidation.REGEX_ACCOUNT)) {
            throw new IllegalArgumentException("Invalid, password cannot empty");
        }
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "account=" + account + ", password=" + password + '}';
    }

}
