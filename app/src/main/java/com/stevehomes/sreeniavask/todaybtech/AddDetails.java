package com.stevehomes.sreeniavask.todaybtech;


public class AddDetails {

    private String Stu_Id;
    private String Stu_Name;
    private String Stu_Mail;
    private String Stu_Phone;
    private String Stu_College;
    private String Stu_Group;
    private String Stu_Year;
    private String Stu_Comments;

    public AddDetails() {

    }
    public AddDetails(String stu_Id, String stu_Name, String stu_Mail, String stu_Phone, String stu_College, String stu_Group, String stu_Year,String stu_Comments) {
        Stu_Id = stu_Id;
        Stu_Name = stu_Name;
        Stu_Mail = stu_Mail;
        Stu_Phone = stu_Phone;
        Stu_College = stu_College;
        Stu_Group = stu_Group;
        Stu_Year = stu_Year;
        Stu_Comments = stu_Comments;

    }

    public String getStu_Id() {
        return Stu_Id;
    }

    public String getStu_Name() {
        return Stu_Name;
    }

    public String getStu_Mail() {
        return Stu_Mail;
    }

    public String getStu_Phone() {
        return Stu_Phone;
    }

    public String getStu_College() {
        return Stu_College;
    }

    public String getStu_Group() {
        return Stu_Group;
    }

    public String getStu_Year() {
        return Stu_Year;
    }

    public String getStu_Comments() {
        return Stu_Comments;
    }
}

