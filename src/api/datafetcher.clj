(ns api.datafetcher
  (:require [import.current-buses :as cb])
  (:gen-class :extends javax.servlet.http.HttpServlet))

(defn -doGet                                                  
  [_ request response]
  (cb/fetch-location-data)
  (let [w (.getWriter response)]                                                       
    (.println w "OK")))