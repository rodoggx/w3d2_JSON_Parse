
package com.example.jsonparse;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("students")
    @Expose
    public List<Student> students = new ArrayList<Student>();

}
