package com.example.laba9.repository;

import com.example.laba9.model.Rent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RentsRepository {
    private static final String FILE_NAME = "rents.json";
    private String filePath;
    private Gson gson = new Gson();

    public RentsRepository(String contextPath) {
        this.filePath = contextPath + FILE_NAME;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Rent> loadRents() {
        try (Reader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<Rent>>(){}.getType();
            List<Rent> rents = gson.fromJson(reader, listType);
            return rents != null ? rents : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void saveRents(List<Rent> rents) {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(rents, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}