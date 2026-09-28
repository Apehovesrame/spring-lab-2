<img width="1359" height="1076" alt="3" src="https://github.com/user-attachments/assets/30f4341e-eb89-4bec-bef7-6fdc09f599f9" />## Цель работы
Реализовать веб-приложение на базе Spring Boot и Spring Data JPA для выполнения базовых CRUD-операций с базой данных H2 для сущности "Военнослужащий" (Вариант 7).

## Архитектура проекта
- **Стек:** Spring Boot 3, Java, Thymeleaf, Spring Data JPA, H2 Database, Maven
- **Основные слои:**
    - **Entity (Модель):** Класс `Serviceman.java` — описывает структуру таблицы в базе данных (поля: ФИО, национальность, дата рождения, должность, звание).
    - **Repository (Репозиторий):** Интерфейс `ServicemanRepository.java` — обеспечивает слой доступа к данным, расширяя `CrudRepository` для выполнения запросов к БД H2 без написания SQL-кода.
    - **Controller (Контроллер):** Класс `ServicemanController.java` — обрабатывает входящие HTTP-запросы, взаимодействует с репозиторием и маршрутизирует данные на представления.
    - **View (Представления):** HTML-страницы с использованием Thymeleaf (`index.html`, `form.html`, `details.html`) для отображения и взаимодействия с пользователем.
- **Ключевые аннотации:**
    - `@Entity` — указывает, что класс является JPA-сущностью, привязанной к таблице базы данных.
    - `@Table` — позволяет задать имя таблицы в базе данных (например, `servicemen`).
    - `@Id` и `@GeneratedValue` — указывают первичный ключ таблицы и стратегию его автогенерации (например, `GenerationType.IDENTITY`).
    - `@Column` — позволяет переопределить имя колонки в таблице (например, `birth_date`).
    - `@Controller` — помечает класс как веб-контроллер Spring MVC.
    - `@RequestMapping` — задает базовый префикс пути (например, `/servicemen`) для всех методов контроллера.
    - `@GetMapping` / `@PostMapping` — обрабатывают соответствующие типы HTTP-запросов.
    - `@PathVariable` — извлекает переменные из URL (например, ID военнослужащего) для поиска или удаления записи.
    - `@ModelAttribute` — связывает данные из HTML-формы с объектом Java при сохранении.

## Алгоритм работы
1. Приложение запускается, Spring Data JPA автоматически генерирует таблицу `servicemen` в базе данных H2, расположенной в оперативной памяти (`mem`).
2. При переходе на адрес `/servicemen` контроллер запрашивает у репозитория все записи (`findAll()`) и передает их в шаблон `index.html`, где они выводятся в виде таблицы.
3. При нажатии "Добавить" открывается форма (`/servicemen/add`), где пользователь заполняет данные военнослужащего.
4. После отправки формы (`POST /servicemen/save`) контроллер принимает объект, сохраняет его в БД через `repository.save()` и делает редирект обратно к списку.
5. Для редактирования (`/servicemen/edit/{id}`) контроллер ищет запись по ID (`findById()`). Если запись найдена, она передается в форму. Наличие скрытого поля с ID на форме заставляет Hibernate обновить существующую запись при сохранении, а не создавать новую.
6. При нажатии "Удалить" (`/servicemen/delete/{id}`) контроллер проверяет наличие записи (`existsById()`) и удаляет ее из базы (`deleteById()`), после чего обновляет список.
7. Дополнительно доступна H2-консоль по адресу `/h2-console` для прямого выполнения SQL-запросов к сгенерированной структуре.

## Скриншоты работы приложения
<img width="1348" height="645" alt="1" src="https://github.com/user-attachments/assets/7cbacb45-6070-473c-8837-d8f2374fa801" />
<img width="1371" height="295" alt="2" src="https://github.com/user-attachments/assets/53da6f18-a4f7-4a89-a15f-7f3d33a44c88" />
<img width="1359" height="1076" alt="3" src="https://github.com/user-attachments/assets/fb55c79d-3f4e-4d96-9052-fd3153e5106c" />
<img width="1373" height="444" alt="4" src="https://github.com/user-attachments/assets/7a8d8c7a-5bf7-4a16-bfa5-b23a1a423371" />
<img width="633" height="474" alt="5" src="https://github.com/user-attachments/assets/9e14d93b-c306-4653-9b01-0867a6ddb9e0" />
<img width="643" height="575" alt="6" src="https://github.com/user-attachments/assets/403fdf1c-8bcd-4d85-aae9-ce2bc5d5b1aa" />
<img width="1077" height="1022" alt="7" src="https://github.com/user-attachments/assets/277322f0-902f-497a-b772-1fc9c2fbb4d5" />
