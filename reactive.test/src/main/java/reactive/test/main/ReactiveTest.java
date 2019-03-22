package reactive.test.main;

import reactor.core.publisher.Flux;

import reactor.core.scheduler.Schedulers;

public class ReactiveTest {

	public static void main(String[] args) {
		
		Flux<Long> integerFlux = Flux.just(1L, 2L, 3L, 5L);

		integerFlux.subscribe(System.out::println);

		integerFlux.map(n -> {
//			if (n > 4)
//				throw new RuntimeException("Error");
			return n * n;
		})
//		.log()
				.subscribe((n) -> System.out.println(n), error -> System.out.println(error));

		Flux<String> empFlux = Flux.just("one", "two", "three");

		empFlux.map(emp -> emp).subscribe();

		empFlux.publishOn(Schedulers.parallel()).map(emp -> emp);

	}
}
