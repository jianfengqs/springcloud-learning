package com.qs.desing.mode.test.chainOfResponsibility;

public class Test {


    public static void main(String[] args) {
        Leader classAdviser = new ClassAdviser();
        Leader departmentHead = new DepartmentHead();
        Leader dean = new Dean();


        classAdviser.setLeader(departmentHead);
        departmentHead.setLeader(dean);

        classAdviser.handleRequest(101);
    }

}
