(ns import.current-buses
	(:require [appengine-clj.datastore :as ds])
	(:require [appengine-clj.enhanced-datastore :as eds])
	(:import 
		(com.google.appengine.api.datastore Query)
		(java.net URL)))

(defn fetch-url
	"Return the contents at a URL as a string"
	[address]
	(let [url (URL. address)]
		(with-open [stream (. url (openStream))]
			(let [buf (java.io.BufferedReader. (java.io.InputStreamReader. stream))]
				(apply str (line-seq buf))))))

(defn store [content]
	(ds/create {:kind "TrackerQuery" :content content}))


(defn fetch-location-data []
	(let [result 
		(fetch-url 
			"http://www.ctabustracker.com/bustime/api/v1/getvehicles?key=kv6yHNkUrkZJkjA8u7V5sxNTq&rt=72,50")]
		(store result)))


(defn structure-fetched-data []
	(let [xml (. (:content (first (eds/find-one "TrackerQuery"))) getValue )]
		xml
	))

