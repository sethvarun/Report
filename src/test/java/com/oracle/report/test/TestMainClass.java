package com.oracle.report.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.oracle.report.exception.RecordException;
import com.oracle.report.main.MainClass;

public class TestMainClass {

   @Test
   public void checkMainClass() {

      MainClass mainclass = new MainClass();
      assertNotNull( mainclass );
   }

   @Test
   public void checkMainClassWithnoArgs() {

      try {
         MainClass.main( new String[]{} );
      }
      catch( RecordException e ) {

         assertEquals( "No arguments has been passed as args", e.getMessage() );
      }
   }

   /*
    * Test happy path. Given all the records are correct
    */
   @ParameterizedTest
   @ValueSource(strings = { "2343225,2345,us_east,RedTeam,ProjectApple,3445s", "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s", "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s", "1233456,2345,us_west,BlueTeam,ProjectDate,2221s", "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s" })
   public void addValidRecord( String args ) throws RecordException {

      MainClass.main( new String[]{ args } );
   }

   /*
    * Test for invalid records. Less no of element in one of the record has been passed
    */
   @ParameterizedTest
   @ValueSource(strings = { "2343225,2345,us_east,RedTeam,ProjectApple,3445s", "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s", "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s", "1233456,2345,us_west,BlueTeam,2221s", "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s" })
   public void addInvalidRecord( String args ) throws RecordException {

      MainClass.main( new String[]{ args } );

   }

   /*
    * Test for invalid records. Empty value for the element has been passed
    */
   @ParameterizedTest
   @ValueSource(strings = { "2343225,2345,us_east,RedTeam,ProjectApple,3445s", "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s", "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s", "1233456,2345,us_west,BlueTeam,,2221s", "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s" })
   public void addEmptyInvalidRecord( String args ) throws RecordException {

      MainClass.main( new String[]{ args } );
   }

}
