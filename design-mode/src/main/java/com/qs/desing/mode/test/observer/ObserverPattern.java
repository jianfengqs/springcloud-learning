package com.qs.desing.mode.test.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    interface Observer {

        void update(String message);

    }

    class ObserverImpl implements Observer {

        private String name;

        public ObserverImpl(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println(name + ":" + message);
        }
    }


    interface Subject {

        void add(Observer observer);

        void remove(Observer observer);

        void notify(String message);

    }

    class SubjectImpl implements Subject {

        private List<Observer> list = new ArrayList<>();

        @Override
        public void add(Observer observer) {
            list.add(observer);
        }

        @Override
        public void remove(Observer observer) {
            list.remove(observer);
        }

        @Override
        public void notify(String message) {
            for (Observer observer : list) {
                observer.update(message);
            }
        }
    }


    public void main2() {
        SubjectImpl subject = new SubjectImpl();

        ObserverImpl observer1 = new ObserverImpl("张三");
        ObserverImpl observer2 = new ObserverImpl("张三");
        subject.add(observer1);
        subject.add(observer2);
        subject.notify("更新了");


    }




}
