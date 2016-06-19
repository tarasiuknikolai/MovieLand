package com.tarasiuk.movieland.dao;

import com.tarasiuk.movieland.dao.jdbc.QueryShaper;
import com.tarasiuk.movieland.dto.MovieQueryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/root-context.xml"})
public class FormQueryTest {

    @Autowired
    QueryShaper queryShaper;

    @Test
    public void testFormOrderClause() {
        assertEquals(queryShaper.formOrderClause("",""), "");
        assertEquals(queryShaper.formOrderClause("asc",""), " ORDER BY 'a', rating asc");
        assertEquals(queryShaper.formOrderClause("desc",""), " ORDER BY 'a', rating desc");
        assertEquals(queryShaper.formOrderClause("","asc"), " ORDER BY 'a', price asc");
        assertEquals(queryShaper.formOrderClause("","desc"), " ORDER BY 'a', price desc");
        assertEquals(queryShaper.formOrderClause("asc","asc"), " ORDER BY 'a', rating asc, price asc");
        assertEquals(queryShaper.formOrderClause("asc","desc"), " ORDER BY 'a', rating asc, price desc");
        assertEquals(queryShaper.formOrderClause("desc","desc"), " ORDER BY 'a', rating desc, price desc");
        assertEquals(queryShaper.formOrderClause("desc","asc"), " ORDER BY 'a', rating desc, price asc");
    }

    @Test
    public void testFormWhereClause() {
    MovieQueryDTO queryQuestion = new MovieQueryDTO();
    assertEquals(queryShaper.formWhereClause(queryQuestion), " WHERE 1=1");
        queryQuestion.setGenre("GeNrE");
        queryQuestion.setNameRus("NameRUS");
        queryQuestion.setNameOrigin("NameORIGIN");
        queryQuestion.setYear(2000);
        queryQuestion.setCountry("CoUnTrY");
        assertEquals(queryShaper.formWhereClause(queryQuestion),
                "JOIN movie_country mc ON mc.movieid = m.id JOIN country c ON c.id = mc.countryid AND c.country = 'CoUnTrY' " +
                "JOIN movie_genre mg ON mg.movieid = m.id JOIN genre g ON g.id = mg.genreid AND g.genre = 'GeNrE' " +
                "WHERE 1=1 AND m.namerus = 'NameRUS' AND m.nameorigin = 'NameORIGIN' AND m.year = 2000");

    }


}

