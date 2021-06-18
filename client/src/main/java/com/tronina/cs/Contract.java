package com.tronina.cs;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contract {
    public static final int RELEVANCE_DURATION_DAYS = 60;

    private int id;
    private Date created;
    private Date updated;


    public Contract() {}

    public Contract(int id, Date created, Date updated) {
        this.id = id;
        this.created = created;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
//        this.isActual = updateActual();
    }



    private long daysBetweenTwoDates(Date date1, Date date2) {
        long diffInMillies = Math.abs(date1.getTime() - date2.getTime());
        long difference = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return difference;
    }

    public boolean getIsActual()  {
        return daysBetweenTwoDates(updated, new Date()) < RELEVANCE_DURATION_DAYS;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}

