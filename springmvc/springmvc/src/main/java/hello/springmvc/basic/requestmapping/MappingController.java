package hello.springmvc.basic.requestmapping;

import org.apache.tomcat.util.http.parser.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";

    }

    @RequestMapping(value="/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "ok";

    }
    /**
     *
     */
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mappingGetV2");
        return "ok";

    }

    /**
     *
     * @return
     */


    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId){
        log.info("mappingPath userId={}", userId);
        return "ok";
    }
    /**
     * PathVariable 다중 매핑
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath userId={}, orderId={}",userId, orderId);
        return "ok";
    }
    /**
     * 파라미터로 추가 매핑
     *
     */
    @GetMapping(value = "/mapping-param", params="mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 헤더 매핑
     * @return
     */
    @GetMapping(value="/mapping-header", headers="mode=debug")
    public String mappingHeader()
    {
        log.info("mappingHeader");
        return "ok";
    }
    @PostMapping(value="/mapping-consume", consumes= "application/json")
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }
    @PostMapping(value="/mapping-produce", consumes="text/html")
    public String mappingProduces(){
        log.info("mappingProduces");
        return "ok";
    }
}
