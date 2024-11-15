package com.ict.edu2;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class SampleController {

    //반환형이 String일때는 브라우저에 String 자체가 출력됨
    @GetMapping("/hello")
    public String getHello() {
        return "Hello, World";
    }

    //반환형이 String[] >> JSON 형식 가지고 출력됨
    @GetMapping("/hello2")
    public String[] getHello2() {
        return new String[]{"Hello","World"};
    }

    //반환형이 객체일 때 

    @GetMapping("/hello3")
    public SampleVO getHello3() {
        SampleVO svo = new SampleVO();
        svo.setName("고길동");
        svo.setAge("24");

        return svo;
    }

      //반환형이 객체일 때 

      @GetMapping("/hello4")
      public List<SampleVO> getHello4() {
        List<SampleVO> list = new ArrayList<>();

        SampleVO svo = new SampleVO();
          svo.setName("고길동");
          svo.setAge("24");

          list.add(svo);

          SampleVO svo2 = new SampleVO();
          svo2.setName("희동이");
          svo2.setAge("3");

          list.add(svo2);

          SampleVO svo3 = new SampleVO();
          svo3.setName("도우너");
          svo3.setAge("17");

          list.add(svo3);
  
          return list;
      }
      //반환형이 객체일때
      @GetMapping("/hello5")
      public DataVO getHello5(String number) {
       
          DataVO dataVO = new DataVO();
          List<SampleVO> list = new ArrayList<>();

            SampleVO svo = new SampleVO("고길동","22");
            SampleVO svo2 = new SampleVO("희동이","3");
            SampleVO svo3 = new SampleVO("도우너","17");
            list.add(svo);
            list.add(svo2);
            list.add(svo3);


        if (number.equals("1")) {
            dataVO.setResultCode(1);
            dataVO.setMessage("성공");
            dataVO.setData(list);
        }else{
            dataVO.setResultCode(0);
            dataVO.setMessage("실패");
            dataVO.setData(null);

        }
  
          return dataVO;
      }
  
    
}
