/*******************************************************************************
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
 ******************************************************************************/

package com.oracle.report.exception;

/**
 * Custom exception class. Error message will be override for any error
 * 
 * @author vseth
 */

public class RecordException extends Exception {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   /**
    * Over loaded constructor
    * 
    * @param errorMessage
    */
   public RecordException( String errorMessage ) {

      super( errorMessage );
   }

}
