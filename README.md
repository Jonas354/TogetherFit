[![CI](https://github.com/Jonas354/TogetherFit/actions/workflows/tests.yml/badge.svg)](https://github.com/Jonas354/TogetherFit/actions/workflows/tests.yml)


# TogetherFit

## Die Idee
Together Fit ist eine Webanwendung, die Sportübungen für unterschiedliche Muskelgruppen, Schwierigkeitslevel und mit oder ohne Zubehör bietet. Sie basiert auf dem Community-Prinzip, nach dem jeder Nutzer Übungen hochladen kann und von den Übungen der Anderen profitiert. Das Ende für eintönige Workouts!

## Die App
Auf der About-Seite wird dem User die Motivation hinter der App sowie die Funktion erklärt. Mit inspirierenden Worten wird angespornt mit dem Training zu starten.

Den zentralen Bestandteil bildet die Exercises-Seite. Auf dieser wird eine Tabelle generiert, die über eine Rest-API mit dem Backend kommuniziert und die in einer Datenbank (Heroku Postgres) gespeicherten Werte ausgibt. Da es eine Vielzahl an Sportübungen in der App geben kann, sind die User in der Lage durch die Tabelle zu scrollen. Mit Hilfe der Suchfunktion direkt unterhalb der Tabelle können die Werte gefiltert werden. So können die User schnell auf die für sie relevanten Inhalte zugreifen. Über den Contribute-Button oberhalb der Tabelle ist es für die User möglich neue Übungen hochzuladen. Dafür öffnet sich an der linken Seite ein Fenster mit einem Formular, das die nötigen Informationen Mit Texteignabefeldern und einem Radio-Button abfragt. Zur Sicherung der Datenqualität ist eine Inputvalidierung im Frontend integriert worden, sodass keine leeren Werte in die Datenbank geladen werden können. Zusätzlich wurde eine Validierung des Inputs im Backend eingebaut.

Zur Erhöhung der Attraktivität der Seite sind mit dem Sport verwandte Bilder im Hintergrund zu sehen, dessen Quellen in einem Footer zu sehen sind. Um die übrigen Elemente der Website mit den Bildern abzustimmen, wurde der Style in CSS definiert.

## Die Tests
Sowohl im Front- als auch im Backend wird mit einer Reihe an Tests die Funktionalität der App sichergestellt. Diese werden automatisiert über GitHub ausgeführt.

## Der Ausblick
Finanziert durch Werbung!

