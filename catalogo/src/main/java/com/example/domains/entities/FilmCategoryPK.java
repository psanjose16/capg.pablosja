package com.example.domains.entities;

import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class FilmCategoryPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="film_id", insertable=false, updatable=false)
    private int filmId;

    @Column(name="category_id", insertable=false, updatable=false)
    private int categoryId;

    public FilmCategoryPK() {
    }

    public FilmCategoryPK(int filmId, int categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }

    public int getFilmId() {
        return this.filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilmCategoryPK)) {
            return false;
        }
        FilmCategoryPK castOther = (FilmCategoryPK) other;
        return this.filmId == castOther.filmId && this.categoryId == castOther.categoryId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.filmId;
        hash = hash * prime + this.categoryId;
        return hash;
    }
}
