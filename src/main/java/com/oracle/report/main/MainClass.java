/*******************************************************************************
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
 ******************************************************************************/

package com.oracle.report.main;

import java.util.Arrays;
import java.util.List;

import com.oracle.report.Records;
import com.oracle.report.exception.RecordException;
import com.oracle.report.listener.PrepareReportAddedListener;
import com.oracle.report.util.HelperUtl;

/**
 * This is the main class which will have main method. it takes multi line string
 * 
 * @author vseth
 */
public class MainClass {

   /**
    * Main method
    * 
    * @param agrs
    * @throws RecordException
    */
   public static void main( String[] agrs ) throws RecordException {

      if( agrs.length == 0 ) {

         throw new RecordException( "No arguments has been passed as args" );
      }

      Records records = new Records();
      
      records.registerRecordAddedListener( new PrepareReportAddedListener() );
      
      List <String> recordList = Arrays.asList( agrs );

      recordList.forEach( e -> {
         try {
            HelperUtl.addRecordTolist( records, e );
         }
         catch( RecordException e1 ) {
            System.err.println( e1.getMessage() );
         }
      } );
      records.unregisterRecordAddedListener( new PrepareReportAddedListener() );

      System.out.println( HelperUtl.getReport() );
   }
}
