javac -d "out/production/Platformer Game" @(Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp "out/production/Platformer Game" main.MainClass
