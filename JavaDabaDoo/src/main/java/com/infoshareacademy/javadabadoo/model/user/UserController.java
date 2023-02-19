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
    // Read a single user by ID
    public function read($id) {
        $user = $this->userService->getUserById($id);

        if (!$user) {
            return response()->json(['message' => 'User not found'], 404);
        }

        return response()->json($user, 200);
    }

    // Update an existing user by ID
    public function update(Request $request, $id) {
        $user = $this->userService->getUserById($id);

        if (!$user) {
            return response()->json(['message' => 'User not found'], 404);
        }

        $this->validate($request, [
                'name' => 'required',
                'email' => 'required|email|unique:users,email,' . $id,
                'password' => 'required|min:8',
        ]);

        $updatedUser = $this->userService->updateUser(
                $user,
                $request->input('name'),
                $request->input('email'),
                $request->input('password')
        );

        return response()->json($updatedUser, 200);
    }
