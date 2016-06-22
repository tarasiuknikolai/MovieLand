package com.tarasiuk.movieland.dao.jdbc;

import com.tarasiuk.movieland.dto.request.SearchMovieRequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
public class QueryShaperTest {

    @Autowired
    QueryShaper queryShaper;

    @Autowired
    private String getAllMoviesSQL;

    @Test
    public void testFormOrderClause() {
        assertEquals(queryShaper.formOrderClause(getAllMoviesSQL, "", ""), getAllMoviesSQL);
        assertEquals(queryShaper.formOrderClause(getAllMoviesSQL, "asc", ""), getAllMoviesSQL + " ORDER BY 'a', rating asc");
        assertEquals(queryShaper.formOrderClause(getAllMoviesSQL, "desc", ""), getAllMoviesSQL + " ORDER BY 'a', rating desc");
        assertEquals(queryShaper.formOrderClause(getAllMoviesSQL, "", "asc"), getAllMoviesSQL + " ORDER BY 'a', price asc");
        assertEquals(queryShaper.formOrderClause(getAllMoviesSQL, "", "desc"), getAllMoviesSQL + " ORDER BY 'a', price desc");
        assertEquals(queryShaper.formOrderClause(getAllMoviesSQL, "asc", "asc"), getAllMoviesSQL + " ORDER BY 'a', rating asc, price asc");
        assertEquals(queryShaper.formOrderClause(getAllMoviesSQL, "asc", "desc"), getAllMoviesSQL + " ORDER BY 'a', rating asc, price desc");
        assertEquals(queryShaper.formOrderClause(getAllMoviesSQL, "desc", "desc"), getAllMoviesSQL + " ORDER BY 'a', rating desc, price desc");
        assertEquals(queryShaper.formOrderClause(getAllMoviesSQL, "desc", "asc"), getAllMoviesSQL + " ORDER BY 'a', rating desc, price asc");
    }

    @Test
    public void testFormWhereClause() {
        SearchMovieRequestDTO queryQuestion = new SearchMovieRequestDTO();
        assertEquals(queryShaper.formWhereClause(getAllMoviesSQL, queryQuestion), getAllMoviesSQL + " WHERE 1=1");
        queryQuestion.setGenre("GeNrE");
        queryQuestion.setNameRus("NameRUS");
        queryQuestion.setNameOrigin("NameORIGIN");
        queryQuestion.setYear(2000);
        queryQuestion.setCountry("CoUnTrY");
        assertEquals(queryShaper.formWhereClause(getAllMoviesSQL, queryQuestion), getAllMoviesSQL +
                "JOIN movie_country mc ON mc.movieid = m.id JOIN country c ON c.id = mc.countryid AND c.country = 'CoUnTrY' " +
                "JOIN movie_genre mg ON mg.movieid = m.id JOIN genre g ON g.id = mg.genreid AND g.genre = 'GeNrE' " +
                "WHERE 1=1 AND m.namerus = 'NameRUS' AND m.nameorigin = 'NameORIGIN' AND m.year = 2000");

    }

}
