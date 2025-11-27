all: sources
	javac @sources.txt

sources:
	find * -name "*.java" > sources.txt

sim:
	java simulator.Simulator scenario.txt

clean:
	find . -name "*.class" -delete

fclean: clean
	rm simulation.txt
	rm sources.txt

.PHONY: all sources sim clean fclean