/*******************************************************************************
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
 ******************************************************************************/
package com.oracle.report;

import java.util.ArrayList;
import java.util.List;

import com.oracle.report.interfaces.IRecordAddedListener;
import com.oracle.report.model.RecordModel;

/**
 * This class is responsible for registering, notifying and unregistering the listener
 * 
 * @author vseth
 */

public class Records {

   private List <IRecordAddedListener> listeners = new ArrayList <IRecordAddedListener>();

   /**
    * Notify each of the listeners in the list of registered listeners
    * 
    * @param recordModel
    */

   public void notifyRecordAddedListeners( RecordModel recordModel ) {

      listeners.forEach( listener -> listener.onRecordAdded( recordModel ) );
   }

   /**
    * Add the listener to the list of registered listeners
    * 
    * @param listener
    */
   public void registerRecordAddedListener( IRecordAddedListener listener ) {

      listeners.add( listener );
   }

   /**
    * Remove the listener from the list of the registered listeners
    * 
    * @param listener
    */
   public void unregisterRecordAddedListener( IRecordAddedListener listener ) {

      this.listeners.remove( listener );
   }

}
