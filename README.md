Разработайте и внедрите API REST с использованием Hibernate / Spring / SpringMVC (или Spring-Boot) без интерфейса.

Задача состоит в том, чтобы:

Создайте систему голосования для принятия решения о том, где пообедать.

2 типа пользователей: администраторы и обычные пользователи
Администратор может ввести ресторан и его обеденное меню дня (обычно 2-5 блюд, просто название блюда и цена).
Меню меняется каждый день (администраторы делают обновления)
Пользователи могут проголосовать за то, в каком ресторане они хотят пообедать
На одного пользователя засчитывается только один голос
Если пользователь проголосует снова в тот же день:
Если это произойдет до 11:00, мы будем считать, что он передумал.
Если это после 11:00, то уже слишком поздно, голосование изменить нельзя
Каждый ресторан каждый день предлагает новое меню.

В результате предоставьте ссылку на репозиторий github. Он должен содержать код, README.md с документацией API и парой команд curl для ее тестирования (лучше - ссылка на Swagger).
