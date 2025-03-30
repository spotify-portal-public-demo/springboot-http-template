package com.spotify.demo.${{ values.java_package_name }};

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello")
public class HelloController {

  public static class HelloObject {
    private final String id;

    public HelloObject(String id) {
      this.id = id;
    }

    public String getId() {
      return id;
    }
  }

  @GetMapping
  public List<HelloObject> findAll() {
    return List.of(new HelloObject("hello"), new HelloObject("world"));
  }

  @GetMapping("/{id}")
  public HelloObject findById(@PathVariable String id) {
    return new HelloObject(id);
  }

}
