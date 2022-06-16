package com.example.springdemostudy.scope;

<<<<<<< HEAD
=======
import lombok.Getter;
import lombok.RequiredArgsConstructor;
>>>>>>> origin/master
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
<<<<<<< HEAD
import javax.inject.Provider;
=======
>>>>>>> origin/master

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
<<<<<<< HEAD
=======

>>>>>>> origin/master
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);
<<<<<<< HEAD

=======
>>>>>>> origin/master
    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class, ClientBean.class);
        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
<<<<<<< HEAD
        assertThat(count2).isEqualTo(1);
=======
        assertThat(count2).isEqualTo(2);
>>>>>>> origin/master
    }

    @Scope("singleton")
    static class ClientBean {
<<<<<<< HEAD

        @Autowired
        private Provider<PrototypeBean> prototypeBeanObjectProvider;

        public int logic() {
            PrototypeBean prototypeBean = prototypeBeanObjectProvider.get();
=======
        private final PrototypeBean prototypeBean;

        @Autowired
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
>>>>>>> origin/master
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

<<<<<<< HEAD

    @Scope("prototype")
=======
    @Scope("prototype")
    @Getter
>>>>>>> origin/master
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

<<<<<<< HEAD
        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
=======
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init" + this);
>>>>>>> origin/master
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
