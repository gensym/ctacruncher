(ns api.structure-fetched-data
  (:require [import.current-buses :as cb])
  (:gen-class :extends javax.servlet.http.HttpServlet))

(defn -doGet                                                  
  [_ request response]
  (let [w (.getWriter response)
		data (cb/structure-fetched-data)]
    (.println w data)))