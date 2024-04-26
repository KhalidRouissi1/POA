package com.example.tp3fx;

import java.util.ArrayList;
import java.util.List;

public class DataClass {
    private List<Persone> importList;
    private List<Persone> exportList;

    public DataClass() {
        this.importList = new ArrayList<Persone>();
        this.importList.add(new Persone("Sami","BenAli","sami@exemple.com"));
        this.importList.add(new Persone("Alia","BenSalah","alia@exemple.com"));
        this.importList.add(new Persone("Ali","BenAli","ali@exemple.com"));
        exportList = new ArrayList<Persone>();

    }

    public List<Persone> getExportList() {
        return exportList;
    }

    public List<Persone> getImportList() {
        return importList;
    }

    public void setImportList(List<Persone> importList) {
        this.importList = importList;
    }

    public void setExportList(List<Persone> exportList) {
        this.exportList.addAll(exportList);
        for(Persone p:this.exportList)
            System.out.println(p);
    }
}
