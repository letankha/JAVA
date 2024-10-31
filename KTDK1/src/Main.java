import java.util.Scanner;
import java.util.ArrayList;

class Account {
    private String accountNumber;
    private String accountName;
    protected double balance;

    public Account(String accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited %.2f to account %s. New balance: %.2f\n", amount, accountNumber, balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrew %.2f from account %s. New balance: %.2f\n", amount, accountNumber, balance);
            return true;
        }
        System.out.println("Insufficient balance.");
        return false;
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Name: " + accountName);
        System.out.println("Balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountName, double balance, double interestRate) {
        super(accountNumber, accountName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.printf("Interest applied: %.2f\n", interest);
    }

    public double getInterestRate() {
        return interestRate;
    }
}

class CheckingAccount extends Account {
    private double transactionFee;

    public CheckingAccount(String accountNumber, String accountName, double balance, double transactionFee) {
        super(accountNumber, accountName, balance);
        this.transactionFee = transactionFee;
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + transactionFee);
    }
}

class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account searchAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        for (Account account : accounts) {
            account.display();
            System.out.println();
        }
    }

    public void applyInterestToSavingsAccounts() {
        for (Account account : accounts) {
            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                savingsAccount.applyInterest();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("1. Thêm tài khoản mới");
            System.out.println("2. Tìm kiếm tài khoản");
            System.out.println("3. Hiển thị tất cả tài khoản");
            System.out.println("4. Tính lãi suất cho tài khoản tiết kiệm");
            System.out.println("5. Nạp tiền vào tài khoản");
            System.out.println("6. Rút tiền từ tài khoản");
            System.out.println("0. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice) {
                case 1:
                    System.out.print("Nhập số tài khoản: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Nhập tên chủ tài khoản: ");
                    String accountName = scanner.nextLine();
                    System.out.print("Nhập số dư: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Chọn loại tài khoản (1: Tiết kiệm, 2: Thanh toán): ");
                    int type = scanner.nextInt();
                    if (type == 1) {
                        System.out.print("Nhập lãi suất: ");
                        double interestRate = scanner.nextDouble();
                        SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountName, balance, interestRate);
                        bank.addAccount(savingsAccount);
                    } else if (type == 2) {
                        System.out.print("Nhập phí giao dịch: ");
                        double transactionFee = scanner.nextDouble();
                        CheckingAccount checkingAccount = new CheckingAccount(accountNumber, accountName, balance, transactionFee);
                        bank.addAccount(checkingAccount);
                    }
                    break;

                case 2:
                    System.out.print("Nhập số tài khoản cần tìm: ");
                    String searchNumber = scanner.nextLine();
                    Account foundAccount = bank.searchAccount(searchNumber);
                    if (foundAccount != null) {
                        foundAccount.display();
                    } else {
                        System.out.println("Không tìm thấy tài khoản.");
                    }
                    break;

                case 3:
                    bank.displayAllAccounts();
                    break;

                case 4:
                    bank.applyInterestToSavingsAccounts();
                    break;

                case 5:
                    System.out.print("Nhập số tài khoản để nạp tiền: ");
                    String depositAccountNumber = scanner.nextLine();
                    Account depositAccount = bank.searchAccount(depositAccountNumber);
                    if (depositAccount != null) {
                        System.out.print("Nhập số tiền muốn nạp: ");
                        double depositAmount = scanner.nextDouble();
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Không tìm thấy tài khoản.");
                    }
                    break;

                case 6:
                    System.out.print("Nhập số tài khoản để rút tiền: ");
                    String withdrawAccountNumber = scanner.nextLine();
                    Account withdrawAccount = bank.searchAccount(withdrawAccountNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Nhập số tiền muốn rút: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Không tìm thấy tài khoản.");
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}