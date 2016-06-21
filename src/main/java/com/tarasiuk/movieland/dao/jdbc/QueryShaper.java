package com.tarasiuk.movieland.dao.jdbc;

import com.tarasiuk.movieland.dto.request.MovieQueryDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QueryShaper {

    @Value("${sql.movie.query.with.country}")
    private String sqlMovieQueryWithCountry;

    @Value("${sql.movie.query.with.genre}")
    private String sqlMovieQueryWithGenre;

    public String formOrderClause(String mainSql, String ratingOrder, String priceOrder) {
        StringBuilder orderClause = new StringBuilder();
        if (ratingOrder != null || priceOrder != null) {
            orderClause.append(OrderClause.contains(ratingOrder)? ", rating " + ratingOrder : "");
            orderClause.append(OrderClause.contains(priceOrder)? ", price " + priceOrder : "");
        }
        return orderClause.length() > 0 ? mainSql + orderClause.insert(0, " ORDER BY 'a'").toString() : mainSql ;
    }

    public String formWhereClause(String mainSql, MovieQueryDTO queryQuestion) {
        StringBuilder orderClause = new StringBuilder();
        orderClause.append(queryQuestion.getCountry() != null ? sqlMovieQueryWithCountry + queryQuestion.getCountry() + "' " : "");
        orderClause.append(queryQuestion.getGenre() != null ? sqlMovieQueryWithGenre + queryQuestion.getGenre() + "'" : "");
        orderClause.append(" WHERE 1=1");
        orderClause.append(queryQuestion.getNameRus() != null ? " AND m.namerus = '" + queryQuestion.getNameRus() + "'" : "");
        orderClause.append(queryQuestion.getNameOrigin() != null ? " AND m.nameorigin = '" + queryQuestion.getNameOrigin() + "'" : "");
        orderClause.append(queryQuestion.getYear() != null ? " AND m.year = " + queryQuestion.getYear() : "");
        return mainSql + orderClause.toString();
    }

}
