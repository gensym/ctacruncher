(ns appengine-clj.enhanced-datastore
	(:require [appengine-clj.datastore :as ds])
  	(:import (com.google.appengine.api.datastore
            DatastoreServiceFactory Entity Key Query Text FetchOptions FetchOptions$Builder)))

(defn find-one
  "Find one of the given kind"
  [#^String kind]
  (let [
		data-service (DatastoreServiceFactory/getDatastoreService)
		prepared-query (.prepare data-service (Query. kind))
		constraint (FetchOptions$Builder/withLimit 1)
		results (.asIterable prepared-query constraint)]
    	(map ds/entity-to-map results)))

