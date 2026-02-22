## Tech Stack ##
Java: 17+
Spring Boot: 3+
Database: SQL Server (localhost:1433)
Build Tool: Maven
ORM: Spring Data JPA
Logging: SLF4J (Logback default)

## code structure ##
com.example.app
│
├── controller
├── service
│   └── impl
├── repository
├── entity
├── config
└── exception
└── SpringBootApplication.java ->> Entry point for Spring boot Application


## application.yml format
spring:
  datasource:
    url: jdbc:sqlserver://localhost:1433;databaseName={{DB_NAME}};encrypt=true;trustServerCertificate=true
    username: {{DB_USERNAME}}
    password: {{DB_PASSWORD}}
    driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
    database-platform: org.hibernate.dialect.SQLServerDialect

  thymeleaf:
    cache: false

server:
  port: 8080

logging:
  level:
    root: INFO
    com.example.app: DEBUG

## Entity Template ##
@Entity
@Table(name = "{{TABLE_NAME}}")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class {{ENTITY_NAME}} {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
}


## Repository template
@Repository
public interface {{ENTITY_NAME}}Repository 
        extends JpaRepository<{{ENTITY_NAME}}, Long> {
}

## Service template ##
public interface {{ENTITY_NAME}}Service {

    {{ENTITY_NAME}} save({{ENTITY_NAME}} entity);

    List<{{ENTITY_NAME}}> findAll();

    {{ENTITY_NAME}} findById(Long id);

    void delete(Long id);
}

## Implementation ##
@Service
@RequiredArgsConstructor
@Slf4j
public class {{ENTITY_NAME}}ServiceImpl 
        implements {{ENTITY_NAME}}Service {

    private final {{ENTITY_NAME}}Repository repository;

    @Override
    public {{ENTITY_NAME}} save({{ENTITY_NAME}} entity) {
        log.info("Saving entity: {}", entity.getName());
        return repository.save(entity);
    }

    @Override
    public List<{{ENTITY_NAME}}> findAll() {
        log.debug("Fetching all entities");
        return repository.findAll();
    }

    @Override
    public {{ENTITY_NAME}} findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> 
                new RuntimeException("Entity not found"));
    }

    @Override
    public void delete(Long id) {
        log.warn("Deleting entity with id {}", id);
        repository.deleteById(id);
    }
}

## Controller ##
@Controller
@RequiredArgsConstructor
@RequestMapping("/{{entityPath}}")
public class {{ENTITY_NAME}}Controller {

    private final {{ENTITY_NAME}}Service service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("items", service.findAll());
        return "{{entityPath}}/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("item", new {{ENTITY_NAME}}());
        return "{{entityPath}}/create";
    }

    @PostMapping
    public String save(@ModelAttribute {{ENTITY_NAME}} entity) {
        service.save(entity);
        return "redirect:/{{entityPath}}";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/{{entityPath}}";
    }
}

## Agent rules ##
Agent must:
1) Use @Slf4j

2) Log:
    save (INFO)
    fetch (DEBUG)
    delete (WARN)

Never log passwords or connection strings

## Constraints ##
Agent MUST:
    Use constructor injection only
    Avoid field injection
    Avoid deprecated annotations
    Follow clean layered architecture
    Use Jakarta imports (Spring Boot 3+)
    Not mix REST and MVC in same controller

## Full Maven project structure ##
pom.xml
application.yml
One fully working CRUD example entity
All corresponding layers