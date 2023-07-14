package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;


    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        //https://stackoverflow.com/questions/29717234/java-adding-another-string-value-to-existing-hashmap-key-without-overwriting
        //if Value is added to a Key with an existing Value it will overwrite that existing Value
        if (this.phonebook.containsKey(name)){
            // if the key has already been used,
            // we'll just grab the array list and add the value to it
            this.phonebook.get(name).add(phoneNumber);
        } else {
            // if the key hasn't been used yet,
            // we'll create a new ArrayList<String> object, add the value
            // and put it in the array list with the new key
            List<String> list = new ArrayList<>();
            list.add(phoneNumber);
            this.phonebook.put(name , list);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        for(String numbers: phoneNumbers){
            add(name, numbers);
        }
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name){
        return this.phonebook.containsKey(name);
    }
    public Boolean hasEntry(String name, String phoneNumbers ) {
        //if a Key exists and if a Key contains a sequence of characters return true or false
        return this.phonebook.containsKey(name) && this.phonebook.get(name).contains(phoneNumbers);
    }

    public List<String> lookup(String name) {
        //https://www.geeksforgeeks.org/field-get-method-in-java-with-examples/#'
        //returns this instance of phonebook
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        //https://www.techiedelight.com/get-map-key-from-value-java/
        //https://www.geeksforgeeks.org/hashmap-keyset-method-in-java/

        //Get a Set of Keys from phonebook or Map object which gives us the name
        // and iterate through each name
        for (String key: this.phonebook.keySet()){
            //key = name
            if (hasEntry(key, phoneNumber)){
                return key;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> contact = new ArrayList<>();

        for (Map.Entry<String, List<String>> map: this.phonebook.entrySet()){
            String name = map.getKey();

            if (hasEntry(name)){
                contact.add(name);
            }
        }
        return contact;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
