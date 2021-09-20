# learning-spring-boot-cassendra
Learning spring boot cassendra integration

To run cassendra run following commands in command prompt/shell:

	docker pull cassandra:latest
	docker run -d -p 9042:9042 cassandra:latest
	
In <b>application.yml</b> file add properties:

	spring:
	  data:
	    cassandra:
	      keyspace-name: todo_management
	      port: 9042
	      contact-points: 127.0.0.1
	      local-datacenter: datacenter1