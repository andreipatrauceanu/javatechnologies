package com.example.javalab2;

import java.util.ArrayList;

public class Repository {
    ArrayList<Record> records = new ArrayList<Record>();

    public Repository() {
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }

    public void addRecord(Record r){
        this.records.add(r);
    }

    @Override
    public String toString() {
        String buffer =  "<table> \n" +
                "<tr> \n"+
                "<th>Category</th>\n" +
                "<th>Value</th>\n" +
                "<th>Key</th>\n" +
                "</tr>\n";
        for(Record r: records){
            buffer +=  "<tr> \n" +
                        "<td> \n" + r.getCategory() + "</td>\n" +
                        "<td> \n" + r.getValue() + "</td>\n" +
                        "<td> \n" + r.getKey() + "</td>\n" +
                        "</tr> \n";
        }
        buffer += "</table>\n";
        return buffer;
    }
}
