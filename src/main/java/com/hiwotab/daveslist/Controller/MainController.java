package com.hiwotab.daveslist.Controller;
import com.hiwotab.daveslist.Model.Person;
import com.hiwotab.daveslist.Model.Room;
import com.hiwotab.daveslist.repositories.PersonRepostory;
import com.hiwotab.daveslist.repositories.RoomRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.ArrayList;


@Controller
public class MainController {

    @Autowired
    RoomRepostory roomRepostory;
    @Autowired
    PersonRepostory personRepostory;

    @GetMapping("/")
    public String showHomePages() {
        return "index";
    }

    @GetMapping("/homePage")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/addOwnerInfo")
    public String addOwnerInfos(Model model) {
        model.addAttribute("newPerson", new Person());
        return "addOwnerInfo";
    }

    @PostMapping("/addOwnerInfo")
    public String addOwnerInfos(@Valid @ModelAttribute("newPerson") Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addOwnerInfo";
        }
        personRepostory.save(person);
        return "dispOwnerIfo";
    }

    @GetMapping("/addRoomInfo")
    public String addRoomInfos(Model model) {
        model.addAttribute("newRoom", new Room());
        return "addRoomInfo";
    }

    @PostMapping("/addRoomInfo")
    public String addRoomInfos(@Valid @ModelAttribute("newRoom") Room room, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addRoomInfo";
        }
        roomRepostory.save(room);
        return "dispRoomIfo";
    }

    @GetMapping("/dispAllRooms")
    public String listAllRoomsInfo(Model model) {
        Room room=new Room();
        Person person = personRepostory.findOne(new Long(1));
        ArrayList<Room> roomArrayList = (ArrayList<Room>) roomRepostory.findAll();
        person.setRoomArrayList(roomArrayList);
        if (room.getAvailability() != null && room.getAvailability()=="yes") {
            model.addAttribute("searchPerson", person);
            return "dispRented";
        } else
            model.addAttribute("searchPersons", person);
        return "dispNotRented";
    }

}
