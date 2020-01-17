package com.thbs.ijp.repository;

import java.util.Comparator;

import com.thbs.ijp.model.Jobb;


public class NameSorter implements Comparator<Jobb> 
{
    @Override
    public int compare(Jobb o1, Jobb o2) {
        return o1.getTitle().compareToIgnoreCase(o2.getTitle());
    }

}
