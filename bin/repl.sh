#!/bin/sh

java -cp .:war/WEB-INF/lib/appengine-api-1.0-sdk-1.2.6.jar:appengine-api-labs-1.2.6.jar:war/WEB-INF/lib/clojure.jar:war/WEB-INF/lib/datanucleus-appengine-1.0.3.jar:war/WEB-INF/lib/datanucleus-core-1.1.5.jar:war/WEB-INF/lib/datanucleus-jpa-1.1.5.jar:war/WEB-INF/lib/geronimo-jpa_3.0_spec-1.1.1.jar:war/WEB-INF/lib/geronimo-jta_1.1_spec-1.1.1.jar:war/WEB-INF/lib/jdo2-api-2.3-eb.jar:util/lib/jline-0.9.94.jar jline.ConsoleRunner clojure.lang.Repl