package com.fynd.movie.management.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.fynd.movie.management.entity.Movies;
import com.fynd.movie.management.service.ILoginService;
import com.fynd.movie.management.service.IMovieManager;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

	private ILoginService loginService;
	IMovieManager movieManager;
	private boolean isAdmin;

	@Autowired
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	@Autowired
	public void setMovieManager(IMovieManager movieManager) {
		this.movieManager = movieManager;
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/login")
	public ResponseEntity login(@RequestHeader(value = "userId") String userId,
			@RequestHeader(value = "password") String password) {
		isAdmin = this.loginService.authenticate(userId, password);
		if (isAdmin) {
			return ResponseEntity.status(HttpStatus.CREATED).body("");

		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials! Please provide valid credentials.");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity getAllMovies() {
		return new ResponseEntity(this.movieManager.getMovies(), HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/addMovie")
	public ResponseEntity addMovie(@RequestBody Movies movie, @RequestHeader(value = "userId") String userId,
			@RequestHeader(value = "password") String password) {
		isAdmin = this.loginService.authenticate(userId, password);
		try {
			if (isAdmin) {

				movieManager.addMovie(movie);
				return ResponseEntity.status(HttpStatus.CREATED).body("Movie added successfully");
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not authorized to view this operation");
			}

		} catch (BadRequest e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					"Server encountered internal error,please contact system administrator");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path="/{name}" ,produces = "application/json")
	public ResponseEntity getMovie(@PathVariable(value = "name") String name) {

		return new ResponseEntity(this.movieManager.getMovies().stream().filter(movie -> movie.getName().equals(name)),
				HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/delete/{name}/{director}")
	public ResponseEntity deleteMovie(@PathVariable(value = "name") String name,
			@PathVariable(value = "director") String director, @RequestHeader(value = "userId") String userId,
			@RequestHeader(value = "password") String password) {

		isAdmin = this.loginService.authenticate(userId, password);
		try {
			if (isAdmin) {
				movieManager.deleteMovie(name, director);
				return ResponseEntity.status(HttpStatus.OK).body("Movie deleted successfully");
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not authorized to do this operation");
			}

		} catch (BadRequest e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					"Server encountered internal error please contact system administator");
		}

	}

	@SuppressWarnings("rawtypes")
	@PutMapping("/update")
	public ResponseEntity updateMovie(@RequestBody Movies movie,@RequestHeader(value = "userId") String userId,
			@RequestHeader(value = "password") String password) {

		isAdmin = this.loginService.authenticate(userId, password);
		try {
			if (isAdmin) {
				movieManager.updateMovie(movie);
				return ResponseEntity.status(HttpStatus.CREATED).body("Movie updated successfully");
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not authorized to do this operation");
			}

		} catch (BadRequest e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					"Server encountered internal error please contact system administator");
		}


	}
	@SuppressWarnings("rawtypes")
	@PostMapping("/addMovies")
	public ResponseEntity addMovies(@RequestBody List<Movies> movie, @RequestHeader(value = "userId") String userId,
			@RequestHeader(value = "password") String password) {
		isAdmin = this.loginService.authenticate(userId, password);
		try {
			if (isAdmin) {

				movieManager.addMovies(movie);
				return ResponseEntity.status(HttpStatus.CREATED).body("Movie added successfully");
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not authorized to view this operation");
			}

		} catch (BadRequest e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					"Server encountered internal error,please contact system administrator");
		}

	}


}
