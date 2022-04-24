package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Publisher;

@Controller
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/publisher/add")
    @ResponseBody
    public String savePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Some publisher name");
        publisherDao.save(publisher);
        return "id of added publisher: " + publisher.getId();
    }

    @GetMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @GetMapping("/publisher/update/{id}/{name}")
    @ResponseBody
    public String updatepublisher(@PathVariable long id, @PathVariable String name) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @GetMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "deleted";
    }
    
}
