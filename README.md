# Movie-Management
This API will manage movie which includes add,update,delete,get movies".For finding movies login(userid,password) is not required and for Rest of operation it is must.
Prerequisite:
userId,password should be present in USER_MASTER Schema.

URL:http://<host>:<port>/movies

Operations

1.Get all Movies
	i)Method: GET
	ii)Uri: "/"
	
2.Get Movies By Name
	i)Method: GET
	ii)uri: "/{name}"
	iii)Path Variable:name

3.Login
	i)Method: GET
	ii)Uri: "/login"
	iii)Request Header: userId,password
		
3.Add Single Movie
	i)Method: POST
	ii)Uri: "/addMovie"
	iii)Request Header: userId,password
	iv)Request Body:Movie
	
4.Add Multiple Movies
	i)Method: POST
	ii)Uri: "/addMovie"
	iii)Request Header: userId,password
	iv)Request Body:List Of Movies
	
5.Update  Movie
	i)Method: PUT
	ii)Uri: "/update"
	iii)Request Header: userId,password
	iv)Request Body:Movie
	
5.Delete  Movie
	i)Method: DELETE
	ii)Uri: "/delete/{name}/{director}"
	iii)Request Header: userId,password
	iv)Path Variable:name,director
	
	
Schemas
 Movie:
  Table:MOVIES
  Type:Object
  Properties:
       popularity=float
       director=String
       genre=List<String>
       imdb_score=float
       name=String
 
 USER_MASTER:
  Table:USER_MASTER
  Type:Object
  Properties:
       DISPLAY_USER_ID=String
       USER_PASSWORD=String
	   
Solution for scaling
1.We will User Kubernetes for scaling as it is an open-source container management tool which holds the responsibilities of container deployment, scaling & descaling of containers & load balancing. Being the Google’s brainchild, it offers excellent community and works brilliantly with all the cloud providers. So, we can say that Kubernetes is not a containerization platform, but it is a multi-container management solution.
2.For Image creation will use docker
3.Please Find DockerFile,Docker-compose.yml file and Kubernetes.yml file for same in containerisation folder.
