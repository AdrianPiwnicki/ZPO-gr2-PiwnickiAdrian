public class Zadanie2 {

    public class Operation{

        public void execute(){}
    }

    public class Interest{

        public void compute(){}
    }

    public class Account{

        long balance;

        public void doOperation(Operation operation){}
    }
    //operation -> execute()

    public class Bank{

        public void balance(){}

        public void transfer(){}

        public void interestChange(){}
    }
    //Operation o = new Income(amount);
    //account.execute(o);


    public class InterestA extends Interest{

        public void compute(){
            super.compute();
        }
    }

    public class InterestB extends Interest{

        public void compute(){
            super.compute();
        }
    }

    public class InterestC extends Interest{

        public void compute(){
            super.compute();
        }
    }

    public class InterestChange extends Operation{

        Account account;
        Interest interest;

        public void execute(){
            super.execute();
        }
    }

    public class Income extends Operation{

        Account account;

        public void execute(){
            super.execute();
        }
    }

    public class Transfer extends Operation{

        Account from;
        Account to;

        public void execute(){
            super.execute();
        }
    }

}
