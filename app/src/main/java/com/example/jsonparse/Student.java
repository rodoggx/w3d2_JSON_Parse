
package com.example.jsonparse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("age")
    @Expose
    public Integer age;
    @SerializedName("grade")
    @Expose
    public Double grade;

}
