package com.qs.desing.mode.test;

public class AbstractFactory {




    abstract class AbstractFactoryMethod{

        public abstract String getFactory(String product);

    }

     class KaFeiFactory extends AbstractFactoryMethod{


        @Override
        public String getFactory(String product) {
            String result;

            switch (product){
                case "natie":
                    result="拿铁";
                    break;

                case "bingkafei":
                    result="冰咖啡";
                    break;
                default:
                    result="未实现";
                    break;
            }

            return result;
        }
    }


    class PiJiuFactory extends AbstractFactoryMethod{

        @Override
        public String getFactory(String product) {
            return null;
        }
    }


    public void main(String[] args) {


    }

}
