package com.infoshareacademy.javadabadoo.model.user;

class UserController {

    protected $userService;

    public function __construct(UserService $userService) {
        $this->userService = $userService;
    }

    // Create a new user
    public function create(Request $request) {
        $this->validate($request, [
                'name' => 'required',
                'email' => 'required|email|unique:users,email',
                'password' => 'required|min:8',
        ]);

        $user = $this->userService->createUser(
                $request->input('name'),
                $request->input('email'),
                $request->input('password')
        );

        return response()->json($user, 201);
    }