(ns code)

(use '[clojure.xml :only (parse)])  
(def xml (parse (java.io.File. "testdata/vehicles_response.xml")))


(defn vehicle-content-xml-to-map
	[xml]
	(let [
		xml-to-map
		(fn [coll tag-attrs]
			(assoc 
				coll 
				(:tag tag-attrs) 
				(let [content (:content tag-attrs)]
					(if (> (count content) 1)
						content
						(first content)))))]
		(reduce xml-to-map {} xml)))
		


(defn make-vehicles
	[xml]
	(map vehicle-content-xml-to-map (map :content (filter #(= (:tag %) :vehicle) (xml-seq xml)))))
	


(defn go
	[]
	(make-vehicles xml))
	

(print (go))
