package com.airbnb;

import java.util.*;

/**
 * Parse an escaped string into CSV format
 *
 * 给定一个CSV文件，格式是 “some_name|some_address|some_phone|some_job”，要求输出Json format “{name:some_name, address:some_addres,phone:some_phone, job:some_job}”
 *
 */
public class CSVParser {
    public static String parseCSV(String input){
        String[] lines = input.split("\n");
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        int size = lines.length;
        for(int i = 0; i < size; i++){
            String[] tokens = lines[i].split("\\|");
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", tokens[0]);
            map.put("address", tokens[1]);
            map.put("phone", tokens[2]);
            map.put("job", tokens[3]);
            list.add(map);
        }

        StringBuilder result = new StringBuilder();
        result.append("{\n");
        Iterator<Map<String, String>> itList = list.iterator();
        while(itList.hasNext()){
            Iterator itMap = itList.next().entrySet().iterator();
            result.append("{");
            while (itMap.hasNext()) {
                Map.Entry entry = (Map.Entry)itMap.next();
                result.append(entry.getKey() + ":" + entry.getValue());

                if(itMap.hasNext()) result.append(",");
            }
            result.append("}");
            if(itList.hasNext()) result.append(",");
            result.append("\n");
        }
        result.append("}\n");
        return result.toString();
    }

    public static String parseCSV2(String input){
        String[] lines = input.split("\n");
        List<Contact> list = new ArrayList<Contact>();
        int size = lines.length;
        for(int i = 0; i < size; i++){
            String[] tokens = lines[i].split("\\|");
            Contact contact = new Contact(tokens[0], tokens[1],tokens[2],tokens[3]);
            list.add(contact);
        }

        StringBuilder result = new StringBuilder();
        result.append("{\n");
        Iterator<Contact> itList = list.iterator();
        while(itList.hasNext()){
            Contact contact = itList.next();
            result.append("{");
            result.append("name:"    + contact.getName()     + ",");
            result.append("address:" + contact.getAddress()  + ",");
            result.append("phone:"   + contact.getPhone()    + ",");
            result.append("job:"     + contact.getJob());
            result.append("}");
            if(itList.hasNext()) result.append(",");
            result.append("\n");
        }
        result.append("}\n");
        return result.toString();
    }

    public static class Contact{
        private String name;
        private String address;
        private String phone;
        private String job;

        public Contact(String name, String address, String phone, String job){
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    public static void main(String[] args){
        String input = "xiaomeng|newport|6313779227|Blackrock\n"
                     + "xiaolu|newport|6464771580|ICBC";
        System.out.println(parseCSV(input));
        System.out.println(parseCSV2(input));
    }
}
